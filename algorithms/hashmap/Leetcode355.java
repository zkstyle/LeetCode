package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-25 10:52
 * @Description: 推特设计
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */
public class Leetcode355 {

    /**
     * 分析：
     *
     * 这是一类系统设计问题（上周我们做过的 LFU 缓存也是属于这一类问题），通常简化了很多需求，只要题目意思理解清楚，一般情况下不难写出，难在编码的细节和调试；
     * 这里需求 3 和需求 4，只需要维护「我关注的人的 id 列表」 即可，不需要维护「谁关注了我」，由于不需要维护有序性，为了删除和添加方便， 「我关注的人的 id 列表」需要设计成哈希表（HashSet），而每一个人的和对应的他关注的列表存在一个哈希映射（HashMap）里；
     * 最复杂的是需求 2 getNewsFeed(userId):
     * 每一个人的推文和他的 id 的关系，依然是存放在一个哈希表里；
     * 对于每一个人的推文，只有顺序添加的需求，没有查找、修改、删除操作，因此可以使用线性数据结构，链表或者数组均可；
     * 使用数组就需要在尾部添加元素，还需要考虑扩容的问题（使用动态数组）；
     * 使用链表就得在头部添加元素，由于链表本身就是动态的，无需考虑扩容；
     * 检索最近的十条推文，需要先把这个用户关注的人的列表拿出来（实际上不是这么做的，请看具体代码，或者是「多路归并」的过程），然后再合并，排序以后选出 Top10，这其实是非常经典的「多路归并」的问题（「力扣」第 23 题：合并K个排序链表），
     * 这里需要使用的数据结构是优先队列，所以在上一步在存储推文列表的时候使用单链表是合理的，并且应该存储一个时间戳字段，用于比较哪一队的队头元素先出列。
     * 剩下的就是一些细节问题了，例如需要查询关注人（包括自己）的最近十条推文，所以要把自己的推文也放进优先队列里。在出队（优先队列）、入队的时候需要考虑是否为空。
     *
     * 总结：
     *
     * 如果需要维护数据的时间有序性，链表在特殊场景下可以胜任。因为时间属性通常来说是相对固定的，而不必去维护顺序性；
     * 如果需要动态维护数据有序性，「优先队列」（堆）是可以胜任的，「力扣」上搜索「堆」（heap）标签，可以查看类似的问题；
     * 设计类问题也是一类算法和数据结构的问题，并且做这一类问题有助于我们了解一些数据结构的大致思想和细节，「力扣」上搜索「设计」标签，可以查看类似的问题；
     * 做完这个问题，不妨仔细思考一下这里使用链表存储推文的原因。
     */
    public static class Twitter {

        /**
         * 用户 id 和推文（单链表）的对应关系
         */
        private Map<Integer, Tweet> twitter;

        /**
         * 用户 id 和他关注的用户列表的对应关系
         */
        private Map<Integer, Set<Integer>> followings;

        /**
         * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
         */
        private static int timestamp = 0;

        /**
         * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
         */
        private static PriorityQueue<Tweet> maxHeap;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            followings = new HashMap<>();
            twitter = new HashMap<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            timestamp++;
            if (twitter.containsKey(userId)) {
                Tweet oldHead = twitter.get(userId);
                Tweet newHead = new Tweet(tweetId, timestamp);
                newHead.next = oldHead;
                twitter.put(userId, newHead);
            } else {
                twitter.put(userId, new Tweet(tweetId, timestamp));
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            // 由于是全局使用的，使用之前需要清空
            maxHeap.clear();

            // 如果自己发了推文也要算上
            if (twitter.containsKey(userId)) {
                maxHeap.offer(twitter.get(userId));
            }

            Set<Integer> followingList = followings.get(userId);
            if (followingList != null && followingList.size() > 0) {
                for (Integer followingId : followingList) {
                    Tweet tweet = twitter.get(followingId);
                    if (tweet != null) {
                        maxHeap.offer(tweet);
                    }
                }
            }

            List<Integer> res = new ArrayList<>(10);
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                Tweet head = maxHeap.poll();
                res.add(head.id);

                // 这里最好的操作应该是 replace，但是 Java 没有提供
                if (head.next != null) {
                    maxHeap.offer(head.next);
                }
                count++;
            }
            return res;
        }


        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         *
         * @param followerId 发起关注者 id
         * @param followeeId 被关注者 id
         */
        public void follow(int followerId, int followeeId) {
            // 被关注人不能是自己
            if (followeeId == followerId) {
                return;
            }

            // 获取我自己的关注列表
            Set<Integer> followingList = followings.get(followerId);
            if (followingList == null) {
                Set<Integer> init = new HashSet<>();
                init.add(followeeId);
                followings.put(followerId, init);
            } else {
                if (followingList.contains(followeeId)) {
                    return;
                }
                followingList.add(followeeId);
            }
        }


        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         *
         * @param followerId 发起取消关注的人的 id
         * @param followeeId 被取消关注的人的 id
         */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            // 获取我自己的关注列表
            Set<Integer> followingList = followings.get(followerId);

            if (followingList == null) {
                return;
            }
            // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
            followingList.remove(followeeId);
        }

        /**
         * 推文类，是一个单链表（结点视角）
         */
        private class Tweet {
            /**
             * 推文 id
             */
            private int id;

            /**
             * 发推文的时间戳
             */
            private int timestamp;
            private Tweet next;

            public Tweet(int id, int timestamp) {
                this.id = id;
                this.timestamp = timestamp;
            }
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}

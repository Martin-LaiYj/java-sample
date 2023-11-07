package com.martin.mysample.demo.utils;

/**
 * RedisPenetrationDemo
 *
 * @author Martin
 * @since 2023-10-12 08:09
 **/

public class RedisPenetrationDemo {

//    /**
//     * 防止缓存穿透->缓存不存在则从库中取出并重新添加缓存
//     *
//     * @param id
//     * @return
//     */
//    public User getHotUserById(String id) {
//        User user = redisTemplate.opsForValue().get(id);
//        if (user == null) {
//            // 如果Redis中不存在，则查询数据库
//            user = userDao.getHotUserById(id);
//            if (user != null) {
//                // 将数据缓存到Redis中，设置过期时间为1小时
//                redisTemplate.opsForValue().set(id, user, 1, TimeUnit.HOURS);
//            }
//        }
//        return user;
//    }
//
//    /**
//     * 防止缓存击穿->缓存不存在则先在缓存中存入空对象,再进数据库查询数据后更新缓存
//     *
//     * @param id
//     * @return
//     */
//    public User getHotUserById(String id) {
//        User user = redisTemplate.opsForValue().get(id);
//        if (user == null) {
//            // 如果Redis中不存在，则写入一个空对象
//            redisTemplate.opsForValue().set(id, new User(), 5, TimeUnit.MINUTES);
//            // 去数据库中查询数据并更新缓存
//            user = userDao.getHotUserById(id);
//            if (user != null) {
//                redisTemplate.opsForValue().set(id, user, 1, TimeUnit.HOURS);
//            }
//        }
//        return user;
//    }
//
//    /**
//     * 防止缓存雪崩->对缓存中每个key设定随机的过期时间
//     *
//     * @return
//     */
//    public List<User> getUserList() {
//        List<User> userList = redisTemplate.opsForValue().get("userList");
//        if (userList == null) {
//            // 如果Redis中不存在，则查询数据库
//            userList = userDao.getUserList();
//            if (userList != null && userList.size() > 0) {
//                // 将数据缓存到Redis中，并增加随机的过期时间
//                int random = new Random().nextInt(600) + 600;
//                redisTemplate.opsForValue().set("userList", userList, random, TimeUnit.SECONDS);
//            }
//        }
//        return userList;
//    }
}

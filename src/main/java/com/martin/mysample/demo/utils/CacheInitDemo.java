package com.martin.mysample.demo.utils;

/**
 * CacheInitDemo
 *
 * @author Martin
 * @since 2023-10-11 17:11
 **/

//@Component
//public class CacheInitDemo implements CommandLineRunner {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 防止系统启动后缓存穿透->在系统启动时取出热点数据后缓存到redis中
//     *
//     * @param args incoming main method arguments
//     * @throws Exception
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        List<User> userList = userDao.getUserList();
//        if (userList != null && userList.size() > 0) {
//            // 将数据缓存到Redis中，并设置过期时间为1小时
//            for (User user : userList) {
//                redisTemplate.opsForValue().set(user.getId(), user, 1, TimeUnit.HOURS);
//            }
//        }
//    }
//}

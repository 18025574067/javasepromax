package com.itheima.run;

import com.itheima.bean.Business;
import com.itheima.bean.Customer;
import com.itheima.bean.Movie;
import com.itheima.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
     系统角色类准备：
        1. 集成日志框架，用于后续记录日志信息。
        2. 定义一个电影类Movie类，Movie类包含：片名，主演，评分，时长，票价，余票。
        3. 系统包含2个用户角色：客户，商家。存在大量相同属性信息。
        4. 定义User类作为父类，属性：登录名称，密码，真实名称，性别，电话，账户金额
        5. 定义Business类代表商家角色，属性：店铺名称，地址。
        6. 定义Customer类代表客户角色，属性：
        7. 定义集合List<User>用户存放系统注册的用户对象信息。
        8. 定义集合Map<Business, List<Movie>>存放商家和其排片信息。

 */

public class MovieSystem {
    /**
        定义系统的用户存储容器:
        1. 存储很多客户对象，商家对象
     */
    public static final List<User> ALL_USERS = new ArrayList<>();

    /**
        2. 存储商家及其排片信息的容器：
            商家1 = [p1, p2, p3...]
            商家2 = [p1, p2, p3...]
     */
    public static final Map<Business, List<Movie>> ALL_MOVIES = new HashMap<>();

    // 扫描器
    public static final Scanner SYS_SC = new Scanner(System.in);

    // 当前登录用户
    public static User loginUser;

    // 定义日期对象
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 日志
    public static final Logger LOGGER = LoggerFactory.getLogger("MovieSystem.class");

    /**
        3. 准备一些测试数据。
     */
    static {
        Customer c = new Customer();
        c.setLoginName("ldh888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意：商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b, movies);

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意：商家一定需要加入到店铺排片信息中去
        List<Movie> movies2 = new ArrayList<>();
        ALL_MOVIES.put(b2, movies2);

    }

    public static void main(String[] args) {
        showMain();
    }

    /**
        首页展示
     */
    private static void showMain() {
        while (true) {
            System.out.println("===============黑马电影首页===================");
            System.out.println("1. 登录");
            System.out.println("2. 客户注册");
            System.out.println("3. 商家入驻");
            System.out.println("请输入操作命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 登录
                    begin();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("你的输入有误，请确认！");
            }
        }
    }

    private static void begin() {
        while (true) {
            System.out.println("请输入用户名：");
            String loginName = SYS_SC.nextLine();
            System.out.println("请输入密码：");
            String passWord = SYS_SC.nextLine();

            // 1. 根据用户查询用户对象
            User u = getUserByLoginName(loginName);

            // 2. 判断登录名是否存在，存在说明用户存在
            if (u != null){
                // 3. 判断密码是否正确
                if (u.getPassWord().equals(passWord)){
                    // 登录成功了
                    loginUser = u;
                    LOGGER.info(u.getLoginName() + "登录了系统～～～");
                    // 判断是普通用户还是商家
                    if (u instanceof Customer){
                        // 普通用户
                        showCustomerMain();
                    }else {
                        // 商户用户
                        showBusinessMain();
                    }
                    return;
                }else {
                    System.out.println("密码错误，请确认！");
                }
            }else {
                System.out.println("登录名错误，请确认！");
            }
        }
    }

    /**
        商家后台操作界面
     */
    private static void showBusinessMain() {
        while (true){
            System.out.println("================黑马电影商家界面================");
            System.out.println(loginUser.getLoginName() + (loginUser.getSex() == '男' ? "先生": "女士")
                + "欢迎您进入系统");
            System.out.println("1. 展示详情");
            System.out.println("2. 上架电影");
            System.out.println("3. 下架电影");
            System.out.println("4. 修改电影");
            System.out.println("5. 退出");

            while (true) {
                System.out.println("请输入您要操作的命令：");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "1":
                        // 展示全部排片信息
                        showBusinessInfos();
                        break;
                    case "2":
                        // 上架电影信息
                        addMovie();
                        break;
                    case "3":
                        // 下架电影信息
                        deleteMovie();
                        break;
                    case "4":
                        // 修改电影信息
                        updateMovie();
                        break;
                    case "5":
                        System.out.println(loginUser.getLoginName() + ", 欢迎下次再来～～～");
                        return; // 干掉方法
                    default:
                        System.out.println("不存在该命令！！");
                        break;
                }
            }
        }
    }

    private static void updateMovie() {
        System.out.println("=================影片修改===================");
        Business business = (Business)loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if (movies.size() == 0){
            System.out.println("当前无影片可以修改！！");
            return;
        }
        // 2. 让用户选择需要修改的电影名称
        while (true) {
            System.out.println("请输入要修改的电影名称：");
            String movieName = SYS_SC.nextLine();

            // 3. 查询有没有这个电影对象
            Movie movie = getMovieByName(movieName);
            if (movie != null){
                // 修改他
                System.out.println("请输入修改后的片名：");
                String name = SYS_SC.nextLine();
                System.out.println("请输入修改后的主演：");
                String actor = SYS_SC.nextLine();
                System.out.println("请输入修改后的时长：");
                String time = SYS_SC.nextLine();
                System.out.println("请输入修改后的票价：");
                String price = SYS_SC.nextLine();
                System.out.println("请输入修改后的票数：");
                String totalNumber = SYS_SC.nextLine();
                while (true) {
                    try {
                        System.out.println("请输入修改后的影片放映时间：");
                        String startTime = SYS_SC.nextLine();

                        // public Movie(String name, String actor, double price,
                        // double time, int number, Date startTime)
                        movie.setName(name);
                        movie.setActor(actor);
                        movie.setTime(Double.valueOf(time));
                        movie.setPrice(Double.valueOf(price));
                        movie.setNumber(Integer.valueOf(totalNumber));
                        movie.setStartTime(sdf.parse(startTime));

                        showBusinessInfos();
                        return; // 直接退出去。

                    } catch (Exception e) {
                        e.printStackTrace();
                        LOGGER.error("时间解析出问题，请确认！！");
                    }
                }
            }else {
                System.out.println("您的店铺没有上架该电影！");
                System.out.println("请问继续修改： y/n");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "y":
                        break;
                    default:
                        return;
                }
            }
        }
    }

    private static void deleteMovie() {
        System.out.println("=================影片下架===================");
        Business business = (Business)loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if (movies.size() == 0){
            System.out.println("当前无排片！！");
            return;
        }
        // 2. 让用户选择需要下架的电影名称
        while (true) {
            System.out.println("请输入要下架的电影名称：");
            String movieName = SYS_SC.nextLine();

            // 3. 查询有没有这个电影对象
            Movie movie = getMovieByName(movieName);
            if (movie != null){
                // 下架他
                movies.remove(movie);
                showBusinessInfos();
                System.out.println("您当前店铺己下架了：" + movie.getName());
                return;
            }else {
                System.out.println("您的店铺没有上架该电影！");
                System.out.println("请问继续下架： y/n");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "y":
                        break;
                    default:
                        System.out.println("好的。");
                        return;
                }
            }
        }
    }

    /**
        去查询当前商家下的排片。
     */
    private static Movie getMovieByName(String movieName) {
        Business business = (Business)loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if (movie.getName().contains(movieName)){
                return movie;
            }
        }return null;
    }

    /**
        商家上架电影
        Map<Business,List<Movie>> ALL_MOVIES.
        u1 = [p1, p2, p3]
        u2 = [p1, p2, p3]

     */
    private static void addMovie() {
        System.out.println("=================影片上架===================");

        // 根据商家对象(登录用户就是loginUser)，作为Map对象的键，提示对应的值就是排片信息:
        // Map<Business,List<Movie>> ALL_MOVIES.
        Business business = (Business)loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        System.out.println("请输入新片名：");
        String name = SYS_SC.nextLine();
        System.out.println("请输入主演：");
        String actor = SYS_SC.nextLine();
        System.out.println("请输入票价：");
        String price = SYS_SC.nextLine();
        System.out.println("请输入时长：");
        String time = SYS_SC.nextLine();
        System.out.println("请输入票数：");
        String totalNumber = SYS_SC.nextLine();
        while (true) {
            try {
                System.out.println("请输入影片放映时间：");
                String startTime = SYS_SC.nextLine();
                // public Movie(String name, String actor, double price,
                // double time, int number, Date startTime)
                Movie movie = new Movie(name, actor, Double.valueOf(price), Double.valueOf(time),
                        Integer.valueOf(totalNumber), sdf.parse(startTime));
                movies.add(movie);
                System.out.println("您已经成功上架了: 《" + movie.getName() + "》");
                return; // 直接退出去。
            } catch (ParseException e) {
                e.printStackTrace();
                LOGGER.error("时间解析出问题，请确认！！");
            }
        }
    }

    /**
        展示商家的详细信息与排片情况
     */
    private static void showBusinessInfos() {
        System.out.println("=================商家详情界面===================");
        LOGGER.info(loginUser.getLoginName() + " 查看了自己的详情。");

        // 根据商家对象(登录用户就是loginUser)，作为Map对象的键，提示对应的值就是排片信息:
        // Map<Business,List<Movie>> ALL_MOVIES.
        Business business = (Business)loginUser;
        System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址："
                + business.getAddress());
        List<Movie> movies = ALL_MOVIES.get(business);
        if (movies.size() > 0) {
            System.out.println("片名\t\t\t\t主演\t\t\t时长\t\t\t评分\t\t票价\t\t\t余票\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println(movie.getName() + "\t\t" + movie.getActor() + "\t\t"
                        + movie.getTime() + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice()
                        + "\t\t" + movie.getNumber() + "\t\t" + sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println("店铺当前无影片上架。");
        }
    }

    /**
        普通用户操作界面
     */
    private static void showCustomerMain() {
        while (true) {
            System.out.println("===================黑马电影客户界面=====================");
            System.out.println(loginUser.getLoginName() + (loginUser.getSex() == '男' ? "先生": "女士")
                    + "欢迎您进入系统" + "\t\t余额：" + loginUser.getMoney());
            System.out.println("1. 展示全部影片信息功能");
            System.out.println("2. 根据电影名称查询电影信息");
            System.out.println("3. 评分功能");
            System.out.println("4. 购票功能");
            System.out.println("5. 退出");
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部影片信息功能
                    showAllMovies();
                    break;
                case "2":
                    // 根据电影名称查询电影信息
                    break;
                case "3":
                    // 评分功能
                    break;
                case "4":
                    // 购票功能
                    buyMovie();
                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
        用户购票功能
     */
    private static void buyMovie() {
        showAllMovies();
        System.out.println("===================用户购票功能=========================");
        while (true) {
            System.out.println("请输入要买票的门店：");
            String shopName = SYS_SC.nextLine();
            // 1. 查询是否存在该商家。
            Business business = getBusinessByShopName(shopName);
            if (business == null){
                System.out.println("对不起，没有该店铺，请确认：");
            }
            // 2. 此商家的全部排片
            List<Movie> movies = ALL_MOVIES.get(business);
            // 3. 判断是否存在上映的电影
            if (movies.size() > 0){
                // 4. 开始进行选片购买
                // 当前商铺，是否有该影片对象
                while (true) {
                    System.out.println("请输入要查询的电影名称：");
                    String movieName = SYS_SC.nextLine();
                    Movie movie = getMovieByShopName(business, movieName);
                    if (movie != null){
                        // 开始购买
                        while (true) {
                            System.out.println("请输入要购买的票数：");
                            String number = SYS_SC.nextLine();
                            int buyNumber = Integer.valueOf(number);
                            // 判断电影是否有存票
                            if (movie.getNumber() >= buyNumber){
                                // 票数够
                                // 当前需要花费的金额
                                double money = BigDecimal.valueOf(movie.getPrice()).multiply(
                                        BigDecimal.valueOf(buyNumber)).doubleValue();
                                if (loginUser.getMoney() >= money){
                                    // 终于可以买票了
                                    System.out.println("您成功购买了" + movie.getName() + buyNumber
                                            + "张电影票，总金额为：" + movie.getPrice() * buyNumber
                                            + "余票：" + movie.getNumber() + "余额：" + loginUser.getMoney());
                                    // 更新余额, 余票
                                    loginUser.setMoney(loginUser.getMoney() - money);
                                    business.setMoney(business.getMoney() + money);
                                    movie.setNumber(movie.getNumber() - buyNumber);
                                    return;
                                }else {
                                    // 钱不够
                                    System.out.println("余额不足！！");
                                    System.out.println("请问继续买票吗？ y/n");
                                    String command = SYS_SC.nextLine();
                                    switch (command){
                                        case "y":
                                            break;
                                        default:
                                            System.out.println("好的。");
                                            return;
                                    }
                                }
                            }else {
                                System.out.println("票数不够！，你只能购买" + movie.getNumber() + "张");
                                System.out.println("请问继续买票吗？ y/n");
                                String command = SYS_SC.nextLine();
                                switch (command){
                                    case "y":
                                        break;
                                    default:
                                        System.out.println("好的。");
                                        return;
                                }
                            }
                        }
                    }else {
                            System.out.println("电影名称有毛病！");
                        }
                }
            }else {
                System.out.println("对不起，电影院关门了！");
                System.out.println("请问继续买票吗？ y/n");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "y":
                        break;
                    default:
                        System.out.println("好的。");
                        return;
                }
            }
        }
    }

    /**
        查询该商铺是否有在查询的电影，并返回。
     */
    public static Movie getMovieByShopName(Business business, String name){
        List<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if (movie.getName().contains(name)){
                return movie;
            }
        }
        return null;
    }

    /**
        根据商家店铺名称查询商家对象
     */
    public static Business getBusinessByShopName(String shopName){
        Set<Business> businesses = ALL_MOVIES.keySet();
        for (Business business : businesses) {
            if (business.getShopName().equals(shopName)){
                return business;
            }
        }
        return null;
    }

    /**
        用户功能：展示全部商家的排片信息。
     */
    private static void showAllMovies() {
        System.out.println("===================展示全部商家排片信息=========================");
        ALL_MOVIES.forEach((business, movies) -> {
            System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone()
                    + "\t\t地址："+ business.getAddress() + "\t\t余额：" + business.getMoney());
            System.out.println("\t\t\t片名\t\t\t\t主演\t\t\t时长\t\t\t评分\t\t票价\t\t\t余票\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println("\t\t\t" +movie.getName() + "\t\t" + movie.getActor()
                        + "\t\t" + movie.getTime() + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice()
                        + "\t\t" + movie.getNumber() + "\t\t" + sdf.format(movie.getStartTime()));
            }
        });
    }

    /**
        判断当前登录用户是否己注册用户
     */
    public static User getUserByLoginName(String loginName){
        for (User user : ALL_USERS) {
            // 判断这个用户是否我们想要的
            if (user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null; // 查无此人。
    }
}

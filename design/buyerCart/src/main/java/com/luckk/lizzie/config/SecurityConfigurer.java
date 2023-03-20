// package com.luckk.lizzie.config;
//
// /**
//  * @Author liukun.inspire
//  * @Date 2023/3/20 17:06
//  * @PackageName: com.luckk.lizzie.config
//  * @ClassName: SecurityConfigurer
//  * @Version 1.0
//  */
//
// import com.luckk.lizzie.service.UserDetailServiceImpl;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
//
// /**
//  * 这里首先继承了 WebSecurityConfigurerAdapter，它是所有 Web配置的接入点
//  * Adapter 即适配器
//  * <p>
//  * 注意 @EnableWebSecurity 注解内置了 @Configurable
//  **/
// // @EnableWebSecurity
// public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//     @Autowired
//     private UserDetailServiceImpl userDetailService;
//
//     /**
//      * 顾名思义，就是建造者模式，它用来构建一个 AuthenticationManager
//      * 添加 UserDetailsService 和 AuthenticationProvider's 就在这里
//      * <p>
//      * 然后它还可以用来
//      */
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth
//                 // 不做具体的 AuthenticationManager 选择这里的默认使用 DaoAuthenticationConfigurer
//                 // 这个 DetailsService 单纯就是从 Dao 层取得用户数据，它不进行密码校验
//                 .userDetailsService(userDetailService)
//                 // 如果上面那个 userDetailsService 够简单其实可以像下面这样用 SQL 语句查询比对
//                 // .dataSource(dataSource)
//                 // .usersByUsernameQuery("Select * from users where username=?")
//                 // 这个 passwordEncoder 配置的实际就是 DaoAuthenticationConfigurer 的加密器
//                 .passwordEncoder(passwordEncoder());
//
//     }
//
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         // return new BCryptPasswordEncoder();
//         // 注意，虽然显示过时了，但是官方没有计划删除它，一般也就使用纯文本密码的测试时会用它
//         return NoOpPasswordEncoder.getInstance();
//     }
// }

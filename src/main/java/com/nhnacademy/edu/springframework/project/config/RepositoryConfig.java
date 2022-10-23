package com.nhnacademy.edu.springframework.project.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project") //project 아래에 있는 모든 컴포넌트를 스캔해서 빈으로 만든다
@EnableAspectJAutoProxy //aspectJ 지원 활성화 어노테이션.........
public class RepositoryConfig {

}

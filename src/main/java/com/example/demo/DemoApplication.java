package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        String hostname = InetAddress.getLocalHost().getHostName();
        String ipAddress = InetAddress.getByName(hostname).getHostAddress();
        System.out.println("IP address of this machine is: " + ipAddress);
		//SpringApplication.run(DemoApplication.class, args);
	}

}

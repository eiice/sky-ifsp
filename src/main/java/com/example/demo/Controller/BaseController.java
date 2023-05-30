package com.example.demo.Controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {
    
    @ResponseBody
	@GetMapping("/list")
	public <Dto> List<Dto> List() //filter
	{
        return new ArrayList<Dto>();
	}
	
    //@ResponseBody
	//@GetMapping()
	// public <Dto> Dto Get(@RequestParam(value = "id", required = true) int id)
	//{
	//	return new Dto();
	//}
}

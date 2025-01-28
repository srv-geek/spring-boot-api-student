package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/studentrecord")
	public String insertData(@RequestBody Student s) {
		String msg = service.insertData(s);
		return msg;
	}

	@DeleteMapping("/deleterecord/{stud_id}")
	public String deleteData(@PathVariable int stud_id) {
		String msg = service.deleteData(stud_id);
		return msg;
	}

	@PutMapping("/updatedata/{stud_id}")
	public String updateData(@RequestBody Student s, @PathVariable int stud_id) {
		String msg = service.updateData(s, stud_id);
		return msg;
	}

	@GetMapping("/getsingledata")
	public Student getSingleRecord(@RequestParam int stud_id) {
		Student s = service.getSingleRecord(stud_id);
		return s;
	}

	@GetMapping("/getalldata")
	public List<Student> getAllRecord() {
		List<Student> list = service.getAllRecord();
		return list;
	}

}

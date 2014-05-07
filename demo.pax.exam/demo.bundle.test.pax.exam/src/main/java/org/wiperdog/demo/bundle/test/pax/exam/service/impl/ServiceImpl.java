package org.wiperdog.demo.bundle.test.pax.exam.service.impl;

import org.wiperdog.demo.bundle.test.pax.exam.service.Service;

public class ServiceImpl implements Service{
	public String run(String message){
		return message;
	}

	public String stop(String message) {
		return message;
	}
}

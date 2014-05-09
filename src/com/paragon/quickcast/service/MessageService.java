package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Message;

@Service
public interface MessageService {
	
	public boolean insert(Message message);
	
	public void update(Message message);
	
	public List queryByDispatchId(int dispatch_id);
	
	public List queryByReceiveId(int receive_id);
	
	public Message queryByMsgId(int msg_id);
	
	public void delete(Message message);
	
	public void deleteByMsgId(int msg_id);
	
	public void deleteByDispatchId(int dispatch_id);
	
	public void deleteByReceiveId(int receive_id);

}

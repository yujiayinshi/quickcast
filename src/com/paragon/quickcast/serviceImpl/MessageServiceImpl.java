package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.MessageDAO;
import com.paragon.quickcast.entity.Message;
import com.paragon.quickcast.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDAO messagedao;

    public boolean insert(Message message){
    	
    	return messagedao.insert(message);
    	
    }
	
	public void update(Message message){
		
		messagedao.update(message);
		
	}
	
	public List queryByDispatchId(int dispatch_id){
		
		return messagedao.queryByDispatchId(dispatch_id);
		
	}
	
	public List queryByReceiveId(int receive_id){
		
		return messagedao.queryByReceiveId(receive_id);
		
	}
	
	public Message queryByMsgId(int msg_id){
		
		return messagedao.queryByMsgId(msg_id);
		
	}
	
	public void delete(Message message){
		
		messagedao.delete(message);
		
	}
	
	public void deleteByMsgId(int msg_id){
		
		messagedao.deleteByMsgId(msg_id);
		
	}
	
	public void deleteByDispatchId(int dispatch_id){
		
		messagedao.deleteByDispatchId(dispatch_id);
		
	}
	
	public void deleteByReceiveId(int receive_id){
		
		messagedao.deleteByReceiveId(receive_id);
		
	}

	public MessageDAO getMessagedao() {
		return messagedao;
	}

	public void setMessagedao(MessageDAO messagedao) {
		this.messagedao = messagedao;
	}

}

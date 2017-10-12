package org.aditi.restwebservices.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.aditi.restwebservices.messenger.database.DatabaseClass;
import org.aditi.restwebservices.messenger.exceptions.DataNotFoundException;
import org.aditi.restwebservices.messenger.model.Message;

public class MessageService 
{
	public MessageService()
	{
		messages.put(1L, new Message(1, "Hello World here I am", "Aditi"));
		messages.put(2L, new Message(2, "Let's learn RESTful webservices", "Jini"));
		messages.put(3L, new Message(3, "This is going to be amazing", "ginie"));
		messages.put(4L, new Message(4, "a lot of learning and some fun", "cutie pie"));
	}
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message> (messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values())
		{
			cal.setTime(message.getCreated());
			
			if(cal.get(Calendar.YEAR) == year)
			{
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size)
	{
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if((start+size) > list.size())
		{
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
	}
	
	public Message getMessage(long id)
	{
		Message message = messages.get(id);
		
		if(message == null)
		{
			throw new DataNotFoundException("Messages with id "+ id +" is not found");
		}
		return message;
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		else
		{
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}

}

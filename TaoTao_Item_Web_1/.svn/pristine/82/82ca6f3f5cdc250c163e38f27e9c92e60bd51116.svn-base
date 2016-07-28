package org.taotao.item.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.taotao.item.service.ItemGenService;

@Component
public class ItemAddListener implements MessageListener {

	@Autowired
	private ItemGenService itemGenService;
	
	@Override
	public void onMessage(Message message) {
		//从消息中获得商品id
		TextMessage textMessage = (TextMessage) message;
		Long itemId = null;
		//取商品id
		try {
			String text = textMessage.getText();
			itemId = new Long(text);
			//生成静态网页
			itemGenService.genItemHtml(itemId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package org.taotao.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.item.service.ItemService;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;
import org.taotao.pojo.TbItemParamItem;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/{itemId}")
	public String showItem(@PathVariable Long itemId, Model model) {
		// 取商品基本信息
		TbItem item = itemService.getItemById(itemId);
		// 取商品描述
		TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);
		// 取商品规格
		TbItemParamItem itemParamItem = itemService.getItemParamByItemId(itemId);
		// 传递给jsp
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", tbItemDesc);
		model.addAttribute("itemParam", itemParamItem);
		// 返回逻辑视图
		return "item";
	}

	@RequestMapping("/item/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParamByItemId(@PathVariable Long itemId) {
		// 取商品规格
		TbItemParamItem itemParamItem = itemService.getItemParamByItemId(itemId);
		// String paramData = itemParamItem.getParamData();
		return TaotaoResult.ok(itemParamItem);
	}
}

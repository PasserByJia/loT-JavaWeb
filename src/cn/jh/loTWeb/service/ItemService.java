package cn.jh.loTWeb.service;

import cn.jh.loTWeb.dao.ItemDao;
import cn.jh.loTWeb.domain.Item;

import java.sql.SQLException;

public class ItemService {
    private ItemDao itemDao = ItemDao.getInstance();
    private static ItemService userService = new ItemService();

    public ItemService() {
    }

    public static ItemService getInstance(){
        return ItemService.userService;
    }

    public Item find(Integer id) throws SQLException {
        return itemDao.find(id);
    }
    public boolean update(Item item) throws SQLException{
        return  itemDao.update(item);
    }
}

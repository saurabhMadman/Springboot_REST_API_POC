package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.entity.IteamList;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InventoryManagementWareHouseDAO implements InventoryManagerInterfaceDAO {

    private final EntityManager entityManager;

    @Autowired
    public InventoryManagementWareHouseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public IteamList findItem(int id) {
        //get current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        //create Query
        IteamList iteamList = session.get(IteamList.class, id);
        session.flush();
        return iteamList;
    }

    public void saveOrUpdate(IteamList iteamList) {
        Session currentSession = getSession();
        currentSession.saveOrUpdate(iteamList);
        currentSession.flush();
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = getSession();
        IteamList iteamList = currentSession.get(IteamList.class, id);
        if (iteamList == null) {
            return -1;
        }
        currentSession.delete(iteamList);
        currentSession.flush();
        return 1;
    }

    public List<IteamList> orderReceivedAll() {
        Session currentSession = getSession();
        List<IteamList> iteamList = currentSession.createQuery("from IteamList").list();
        return iteamList;
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
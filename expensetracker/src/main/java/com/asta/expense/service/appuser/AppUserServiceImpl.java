package com.asta.expense.service.appuser;

import com.asta.expense.dao.AppUserRepository;
import com.asta.expense.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> findAllAppUser() {
        return appUserRepository.findAll();
    }
}

package com.asta.expense.mapper;

import com.asta.expense.model.AppUser;
import com.asta.expense.payload.dto.AppUserForm;
import com.asta.expense.reftype.YNStatus;
import com.asta.expense.utils.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Qualifier("AppUserMapper")
public class AppUserMapper {

    public AppUser map(AppUserForm appUserForm) {
        AppUser appUser = new AppUser();
        appUser.setName(appUserForm.getName());
        appUser.setUsername(appUserForm.getUsername());
        appUser.setPassword(appUserForm.getPassword());
        appUser.setDeleted(YNStatus.NO.getStatus());
        appUser.setCreatedBy(StringUtils.user);
        appUser.setCreatedOn(StringUtils.now);
        return appUser;
    }
    public Boolean checkAppUser(AppUserForm appUserForm,AppUser appUser) {
        boolean isAppUser =false;
        if(Objects.equals(appUserForm.getUsername(), appUser.getUsername())){
            if(Objects.equals(appUserForm.getPassword(), appUser.getPassword())){
                isAppUser = true;
            }
        }
        return isAppUser;
    }

}

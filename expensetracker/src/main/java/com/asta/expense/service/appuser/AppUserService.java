package com.asta.expense.service.appuser;

import com.asta.expense.model.AppUser;

import java.util.Optional;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser);
    Optional<AppUser> getAppUserByUsername(String userName);

}

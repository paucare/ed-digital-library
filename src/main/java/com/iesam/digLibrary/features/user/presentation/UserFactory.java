package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.*;

public class UserFactory {

    UserDataRepository dataRepository = new UserDataRepository( new UserFileLocalDataSource());

    public SaveUserUseCase buildSaveUser(){
        return new SaveUserUseCase(dataRepository);
    }

    public DeleteUserUseCase buildDeleteUser(){
        return new DeleteUserUseCase(dataRepository);
    }

    public UpdateUserUseCase buildUpdateUser(){
        return new UpdateUserUseCase(dataRepository);
    }

    public GetUserByIdUseCase buildGetUserById(){
        return new GetUserByIdUseCase(dataRepository);
    }

    public GetUsersUseCase buildGetAllUsers(){
        return new GetUsersUseCase(dataRepository);
    }
}

package br.felipeberbert.mvplearning;

import org.junit.Before;
import org.junit.Test;

import br.felipeberbert.mvplearning.login.LoginActivityMVP;
import br.felipeberbert.mvplearning.login.LoginActivityPresenter;
import br.felipeberbert.mvplearning.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Felipe Berbert on 19/07/2017.
 */

public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;

    User user;

    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("John", "Doe");

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void loadUserFromRepositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();
        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, times(1)).setFirstName("John");
        verify(mockView, times(1)).setLastName("Doe");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();
        verify(mockLoginModel, times(1)).getUser();

        verify(mockView, never()).setFirstName("John");
        verify(mockView, never()).setLastName("Doe");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldsAreEmpty(){
        when(mockView.getFirstName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        when(mockView.getFirstName()).thenReturn("Lorry");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveValidUser(){
        when(mockView.getFirstName()).thenReturn("Loris");
        when(mockView.getLastName()).thenReturn("Battachi");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        verify(mockLoginModel, times(1)).createUser("Loris", "Battachi");

        verify(mockView, times(1)).showUserSavedMessage();
    }
}

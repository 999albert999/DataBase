package com.digi;

import com.digi.model.User;
import com.digi.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User albert = new User(0,"Albert","Hovhannisyan",24,"alberthovhannisyan24@gmail.com","qwerty1234");
        User poxAlbert = new User(0,null,null,18,"alberthovhannisyan24@gmail.com",null);
        User karen = new User(0,"Karen","Mnacakanyan",24,"karenmn@mail.ru","dzknik1234");
        User vigen = new User(0,"Vigen","Gevorgyan",33,"vigengevorgyan@gmail.com","zcbm1234");
        User avetis = new User(0,"Avetis","Sanosyan",36,"avsanosyan@list.ru","adgj1234");
        User varazdat = new User(0,"Varazdat","Manasaryan",28,"vroplaycity@gmail.com","tgrf9876");
        User myasnik = new User(0,"Myasnik","Antonyan",28,"myasnik197@gmail.com","tyui2871");
        User narek = new User(0,"Narek","Atoyan",28,"naratoyan@gmail.com","fxkoqqe324");

        UserRepository.insert(albert);
        UserRepository.insert(karen);
        UserRepository.insert(vigen);
        UserRepository.insert(avetis);
        UserRepository.insert(varazdat);
        UserRepository.insert(myasnik);
        UserRepository.insert(narek);
        System.out.println(UserRepository.getAll());
        System.out.println("***************************************************************************");
        UserRepository.update(poxAlbert);
        System.out.println(UserRepository.getAll());
        System.out.println("***************************************************************************");
        UserRepository.delete(myasnik);
        System.out.println(UserRepository.getAll());
        System.out.println("***************************************************************************");


    }
}

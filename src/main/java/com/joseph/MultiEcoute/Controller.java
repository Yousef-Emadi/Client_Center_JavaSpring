package com.joseph.MultiEcoute;

public class Controller {

    //new objects
    UserPanel myUI = new UserPanel();
    ClientsList myClientList = new ClientsList();

    public void mainController(){
        userChoice myUserChoice = myUI.requestUserOption();
        switch (myUserChoice) {
            case CREATE -> {doCreate();}
            case FIND -> {doFindAndShowClient();}
            case REMOVE -> {doFindAndRemoveClient();}
            case EXIT -> {doExit();}
        }
    }

    // Process and Do
    public void doCreate(){
        Client newClient = myUI.getNewClientToCreate();
        if (newClient != null){
            myClientList.addNewClient(newClient);
            myClientList.writeIntoFile(newClient);
            myUI.successfulMessage();
        }else
            myUI.failureMessage();
    }

    public void doFindAndShowClient(){
        int id = myUI.getClientIdToSearch();
        Client foundClient = myClientList.findClient(id);
        myUI.showClient(foundClient);
    }

    public void doFindAndRemoveClient(){
        int id = myUI.getClientIdToRemove();
        Client foundClient = myClientList.findClient(id);
        myClientList.removeClient(foundClient);
        myUI.successfulMessage();
    }

    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }
}


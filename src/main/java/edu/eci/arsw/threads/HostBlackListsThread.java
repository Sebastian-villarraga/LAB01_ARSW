package edu.eci.arsw.threads;

import java.util.LinkedList;
import edu.eci.arsw.blacklistvalidator.HostBlackListsValidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListsThread extends Thread {

    private int start;
    private int end;
    private String ipaddress;
    private int ocurrencesCount;
    private int checkedListsCountThread;
    private HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
    private LinkedList<Integer> blackListOcurrences = new LinkedList<>();

    public HostBlackListsThread(int start, int end, String ipaddress) {
        this.start = start;
        this.end = end;
        this.ipaddress = ipaddress;
        this.ocurrencesCount = 0;
        this.checkedListsCountThread = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end && ocurrencesCount < HostBlackListsValidator.getBlackListAlarmCount(); i++) {
            checkedListsCountThread++;
            if (skds.isInBlackListServer(i, ipaddress)) {
                blackListOcurrences.add(i);
                ocurrencesCount++;
            }
        }
    }

    public int getCheckedListsCountThread() {
        return checkedListsCountThread;
    }

    public LinkedList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }

    public int getOcurrencesCount() {
        return ocurrencesCount;
    }
}

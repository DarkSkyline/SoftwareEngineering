package com.es2.memento;

public class BackupService extends Object {
    Server server;

    public BackupService(Server server) {
        this.server = server;
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {

        try {
            if(snapshotNumber < 1) {
                throw new NotExistingSnapshotException();
            }
        } catch (NotExistingSnapshotException e) {
            System.out.println("Snapshot doesn't exist!");
        }

    }

    public void takeSnapshot() {
        System.out.println("Snapshot created");
    }
}

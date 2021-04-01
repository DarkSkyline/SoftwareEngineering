package com.es2.memento;

import java.util.ArrayList;

public class BackupService extends Object {
    private Server server;
    private ArrayList<Memento> serverSnapshots = new ArrayList<>();

    public BackupService(Server server) {
        this.server = server;
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if (snapshotNumber < 0 || snapshotNumber > this.serverSnapshots.size() - 1) {
            throw new NotExistingSnapshotException();
        }

        this.server.restore(this.serverSnapshots.get(snapshotNumber));
    }

    public void takeSnapshot() {
        this.serverSnapshots.add(server.backup());
    }
}

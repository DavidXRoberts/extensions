/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.ras.couchdb.internal;

import java.nio.file.Path;

import dev.galasa.framework.spi.IRunResult;
import dev.galasa.framework.spi.ResultArchiveStoreException;
import dev.galasa.framework.spi.teststructure.TestStructure;

public class CouchdbRunResult implements IRunResult {

    private final TestStructure   testStructure;
    private final Path            path;
    private final CouchdbRasStore store;

    public CouchdbRunResult(CouchdbRasStore store, TestStructure testStructure, Path path) {
        this.store = store;
        if (testStructure == null) {
            this.testStructure = new TestStructure();
        } else {
            this.testStructure = testStructure;
        }
        this.path = path;
    }

    @Override
    public TestStructure getTestStructure() throws ResultArchiveStoreException {
        return this.testStructure;
    }

    @Override
    public Path getArtifactsRoot() throws ResultArchiveStoreException {
        return this.path;
    }

    @Override
    public String getLog() throws ResultArchiveStoreException {
        return this.store.getLog(this.testStructure);
    }

	@Override
	public void discard() throws ResultArchiveStoreException {
		// TODO Auto-generated method stub
		
	}

}

package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DocumentManagementSystemTest {
    private DocumentManagementSystem dms;

    @Before
    public void setUp() {
        dms = new DocumentManagementSystem();
        System.out.println("Setup complete.");
    }

    @Test
    public void testAddDocument() {
        Document doc = new Document(1, "Test Title", "Test Content");
        dms.addDocument(doc);
        assertEquals(1, dms.listAllDocuments().size());
        System.out.println("testAddDocument passed.");
    }

    @Test
    public void testGetDocumentById() {
        Document doc = new Document(1, "Test Title", "Test Content");
        dms.addDocument(doc);
        Document retrievedDoc = dms.getDocumentById(1);
        assertNotNull(retrievedDoc);
        assertEquals("Test Title", retrievedDoc.getTitle());
        System.out.println("testGetDocumentById passed.");
    }

    @Test
    public void testUpdateDocument() {
        Document doc = new Document(1, "Test Title", "Test Content");
        dms.addDocument(doc);
        dms.updateDocument(1, "Updated Content");
        Document updatedDoc = dms.getDocumentById(1);
        assertEquals("Updated Content", updatedDoc.getContent());
        System.out.println("testUpdateDocument passed.");
    }

    @Test
    public void testDeleteDocument() {
        Document doc = new Document(1, "Test Title", "Test Content");
        dms.addDocument(doc);
        dms.deleteDocument(1);
        assertNull(dms.getDocumentById(1));
        System.out.println("testDeleteDocument passed.");
    }

    @Test
    public void testListAllDocuments() {
        Document doc1 = new Document(1, "Title 1", "Content 1");
        Document doc2 = new Document(2, "Title 2", "Content 2");
        dms.addDocument(doc1);
        dms.addDocument(doc2);
        List<Document> documents = dms.listAllDocuments();
        assertEquals(2, documents.size());
        System.out.println("testListAllDocuments passed.");
    }

    @Test
    public void testAddDocumentWithSameId() {
        Document doc1 = new Document(1, "Title 1", "Content 1");
        Document doc2 = new Document(1, "Title 2", "Content 2");
        dms.addDocument(doc1);
        dms.addDocument(doc2);
        assertEquals(2, dms.listAllDocuments().size());
        System.out.println("testAddDocumentWithSameId passed.");
    }

    @Test
    public void testGetNonExistentDocumentById() {
        Document retrievedDoc = dms.getDocumentById(999);
        assertNull(retrievedDoc);
        System.out.println("testGetNonExistentDocumentById passed.");
    }

    @Test
    public void testUpdateNonExistentDocument() {
        dms.updateDocument(999, "Non-existent Content");
        assertNull(dms.getDocumentById(999));
        System.out.println("testUpdateNonExistentDocument passed.");
    }

    @Test
    public void testDeleteNonExistentDocument() {
        dms.deleteDocument(999);
        assertEquals(0, dms.listAllDocuments().size());
        System.out.println("testDeleteNonExistentDocument passed.");
    }
}

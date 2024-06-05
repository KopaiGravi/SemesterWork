package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentManagementSystem {
    private List<Document> documents;

    public DocumentManagementSystem() {
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document doc) {
        documents.add(doc);
    }

    public Document getDocumentById(int id) {
        Optional<Document> document = documents.stream()
                .filter(doc -> doc.getId() == id)
                .findFirst();
        return document.orElse(null);
    }

    public void updateDocument(int id, String newContent) {
        Document document = getDocumentById(id);
        if (document != null) {
            document.setContent(newContent);
        }
    }

    public void deleteDocument(int id) {
        documents.removeIf(doc -> doc.getId() == id);
    }

    public List<Document> listAllDocuments() {
        return new ArrayList<>(documents);
    }

    public void saveDocumentsToFile(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(documents);
        }
    }

    public void loadDocumentsFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            documents = (List<Document>) ois.readObject();
        }
    }
}
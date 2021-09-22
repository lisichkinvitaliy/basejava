package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;


    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            size = 0;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("ERROR Resume already exist");
        } else if (size == storage.length) {
            System.out.println("ERROR Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("ERROR Resume not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR Resume not exist");
            return null;
        }
        return storage[index];
    }

    private int getIndex(String uuid) {
        for (int j = 0; j < size; j++) {
            if (uuid == storage[j].getUuid()) return j;
        }
        return -1;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        System.arraycopy(storage, 0, allResume, 0, allResume.length);
        return allResume;
    }

    public int size() {
        return size;
    }
}

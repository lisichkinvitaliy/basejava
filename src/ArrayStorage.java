import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            size = 0;
        }
    }

    void save(Resume r) {
        storage[size] = r;
        ++size;
    }

    Resume get(String uuid) {
        return (Resume) Arrays.stream(storage).filter((p) -> p.uuid.equals(uuid));
    }

    void delete(String uuid) {
        int indeksElem = 0;
        for (int j = 0; j < size; j++) {
            if (!storage[j].uuid.equals(uuid)) continue;
            storage[j] = null;
            indeksElem = j;
            --size;
            break;
        }
        for (int i = indeksElem; i < size; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        System.arraycopy(storage, 0, allResume, 0, allResume.length);
        return allResume;
    }

    int size() {
        return size;
    }
}

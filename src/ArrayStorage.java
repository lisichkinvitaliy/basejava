import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    //проверяем в цикле весь массив, так как null не может быть между значениями, при нахождении null прерываем поиск
    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                size = 0;
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            } else ++size;
        }
    }

    Resume get(String uuid) {
        return (Resume) Arrays.stream(storage).filter((p) -> p.uuid.equals(uuid));
    }

    void delete(String uuid) {
        Resume[] temMass = new Resume[storage.length - 1];//временный массив га длинну нашего-1 для хранения массива после удаления уид
        for (int j = 0; j < storage.length; j++) {
            if (!storage[j].uuid.equals(uuid)) {
                continue;
            } else {
                storage[j] = null;
                --size;
                break;
            }
        }
        //циклом перемещаем значения из нашего массива в темп не копируя в темп элемент со значением null
        //переменная Х создана для того что бы индекс в новом массиве был без Null
        int x = 0;
        for (int i = 0; i < temMass.length; i++) {
            if (storage[i] != null) {
                temMass[x] = storage[i];
                x++;
            }
        }
        System.arraycopy(temMass, 0, storage, 0, temMass.length);


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int k = size;
        Resume[] tmp = new Resume[k];
        System.arraycopy(storage, 0, tmp, 0, tmp.length);
        return tmp;
    }

    int size() {
        return size;
    }
}

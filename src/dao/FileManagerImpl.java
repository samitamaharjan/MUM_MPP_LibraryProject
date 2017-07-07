package dao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import interfaces.PrimaryKey;


public class FileManagerImpl<T extends PrimaryKey> implements FileManager<T> {
	
	private String filename;
	
	public FileManagerImpl(String filename) {
		this.filename = filename;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<>();

		try (ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream(filename))) {
			list = (List<T>) ois.readObject();
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public T findByPrimaryKey(String id) {
		List<T> list = findAll();
		
		for (T t : list) {
			if (t.getPrimaryKey().equals(id)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public void insert(T t) {
		List<T> list = findAll();
		list.add(t);
		
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void clean() {
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(new ArrayList<>());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		List<T> list = findAll();
		
		for (T t : list) {
			if (t.getPrimaryKey().equals(id)) {
				list.remove(t);
				break;
			}
		}
		
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void edit(T t) {
		delete(t.getPrimaryKey());
		insert(t);
	}

	@Override
	public void print() {
		List<T> list = findAll();
		
		for (T t : list) {
			System.out.println(t);
		}
	}

	@Override
	public boolean exists(String id) {
		if (findByPrimaryKey(id) != null) return true;
		return false;
	}
}
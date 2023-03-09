package edu.ics372.GroupProject1.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ics372.GroupProject1.entities.Product;
import edu.ics372.GroupProject1.facade.Result;

public class ProductIterator implements Iterator<Result> {
	private Iterator<Product> iterator;
	private Result result = new Result();

	public ProductIterator(Iterator<Product> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Result next() {
		if (iterator.hasNext()) {
			result.setProductFields(iterator.next());
		} else {
			throw new NoSuchElementException("No such element");
		}
		return result;
	}

}

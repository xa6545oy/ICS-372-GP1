package edu.ics372.GroupProject1.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ics372.GroupProject1.entities.Member;
import edu.ics372.GroupProject1.facade.Result;

public class MemberIterator implements Iterator<Result> {
	private Iterator<Member> iterator;
	private Result result = new Result();

	/**
	 * The user of MemberIterator must supply an Iterator to Member.
	 * 
	 * @param iterator Iterator<Member>
	 */
	public MemberIterator(Iterator<Member> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Result next() {
		if (iterator.hasNext())
			result.setMemberFields(iterator.next());
		else
			throw new NoSuchElementException("No element");
		return result;
	}
}

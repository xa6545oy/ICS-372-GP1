package edu.ics372.GroupProject1.collections;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.ics372.GroupProject1.entities.Member;

/**
 * The collection class for Member objects
 * 
 * @author Ethan Lo
 */
public class MemberList implements Iterable<Member>, Serializable {
	private static final long serialVersionUID = 1L;
	private List<Member> members = new LinkedList<Member>();
	private static MemberList memberList;

	/*
	 * Private for singleton Creates members collection object
	 */
	private MemberList() {
	}

	public static MemberList getInstance() {
		if (memberList == null) {
			memberList = new MemberList();
		}
		return memberList;
	}

	/*
	 * Returns the members list
	 * 
	 * @return iterates members list
	 */
	public Iterator<Member> iterator() {
		return members.iterator();
	}

	/**
	 * Inserts a member into the members list
	 * 
	 * @param member to be inserted
	 * @return true if the member could be inserted
	 */
	public boolean insertMember(Member member) {
		members.add(member);
		return true;
	}
	
	/*
	 * Removes a member from the memberList
	 * 
	 * @param memberId is the member id
	 * @return true if member is removed
	 */
	public boolean removeMember(String memberId) {
		Member member = search(memberId);
		
		if(member == null)
			return false;
		else
			return members.remove(member);
	}

	/**
	 * Checks if a member exists using the member id
	 * 
	 * @param memberId the id of the member
	 * @return true if member exists otherwise it returns null
	 */
	public Member search(String memberId) {
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
			Member member = iterator.next();
			if (member.getMemberId().equals(memberId)) {
				return member;
			}
		}
		return null;
	}

	/**
	 * String form of the collection
	 */
	@Override
	public String toString() {
		return members.toString();
	}
}
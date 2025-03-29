package com.ssg.io.member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	private List<Member> members = new ArrayList<>();
	private File target = new File("KimDonghyun/_14_io", "members.ser");


	public void readMembers() {
		if(this.members.isEmpty()) {
			try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)));){
				this.members = (List<Member>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// 출력
		for(Member m : members){
			System.out.println(m);
		}
	}
	public void addMember(Member member) {
		this.members.add(member);
		writeMember(members);
	}

	public void writeMember(List<Member> members) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))){
			oos.writeObject(members);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
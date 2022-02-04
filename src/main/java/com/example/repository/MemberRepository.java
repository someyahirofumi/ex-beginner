package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Member> MEMBER_ROW_MAPPER=new BeanPropertyRowMapper<>(Member.class);
	
	public Member check(String name) {
		String sql="SELECT * FROM members WHERE name like'%:name%;";
		SqlParameterSource param=new MapSqlParameterSource("name",name);
		Member member = template.queryForObject(sql, param, MEMBER_ROW_MAPPER);
		return member;
	}

}

package com.order.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.order.ordermanagement.entity.DatabaseSequence;

@Component
public class SequenceGeneratorService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public long generateSequence(String seqName) {
		DatabaseSequence counter = mongoTemplate.findAndModify(Query.query(Criteria.where("_id").is(seqName)),
				new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
				DatabaseSequence.class);

		return counter != null ? counter.getSeq() : 1;
	}

}

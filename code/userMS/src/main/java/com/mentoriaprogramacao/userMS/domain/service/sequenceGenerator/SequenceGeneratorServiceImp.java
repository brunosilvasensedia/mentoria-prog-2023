package com.mentoriaprogramacao.userMS.domain.service.sequenceGenerator;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mentoriaprogramacao.userMS.domain.entity.DatabaseSequence;

@Service
public class SequenceGeneratorServiceImp implements SequenceGeneratorService{

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorServiceImp(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long generateSequence(String seqName) {
        Query query = Query.query(Criteria.where("_id").is(seqName));

        DatabaseSequence counter = mongoOperations.findAndModify(query,
        new Update().inc("seq",1), FindAndModifyOptions.options().returnNew(true).upsert(true),
        DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
    
}

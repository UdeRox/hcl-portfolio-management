package com.ude.hackathon.hcl.instrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}

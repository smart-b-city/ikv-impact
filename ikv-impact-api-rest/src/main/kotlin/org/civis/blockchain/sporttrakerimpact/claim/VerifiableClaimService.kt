package org.civis.blockchain.sporttrakerimpact.claim

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import info.weboftrust.ldsignatures.signer.RsaSignature2017LdSigner
import org.civis.blockchain.ssm.client.domain.SignerAdmin
import org.springframework.stereotype.Service
import java.net.URI
import java.security.interfaces.RSAPrivateKey
import java.time.LocalDateTime
import java.util.*

@Service
class VerifiableClaimService(val objectMapper: ObjectMapper, val signerAdmin: SignerAdmin) {

    fun sign(trip: Claim): LinkedHashMap<String, Any> {
        val json: LinkedHashMap<String, Any> = objectMapper.convertValue(trip)
        val creator = URI.create("https://smart-b.city")
        val domain = "smart-b.city"
        val created = LocalDateTime.now().toString()
        val nonce: String? = UUID.randomUUID().toString()

        val signer = RsaSignature2017LdSigner(creator, created, domain, nonce, signerAdmin.pair.private as RSAPrivateKey)
        signer.sign(json)
        return json
    }

}
package org.civis.blockchain.sporttrakerimpact

import org.civis.blockchain.ssm.client.SsmClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import info.weboftrust.ldsignatures.signer.RsaSignature2017LdSigner
import org.civis.blockchain.ssm.client.domain.SignerAdmin
import java.net.URI
import java.security.interfaces.RSAPrivateKey
import java.util.*

@RestController
class ImpactApi(val ssmClient: SsmClient,
             val signerAdmin: SignerAdmin) {

    @GetMapping("/impact")
    fun impact(): CompletableFuture<MutableList<String>> = ssmClient.listAdmins()

    @GetMapping("/signed")
    fun impactSign(): LinkedHashMap<String, Any>? {
        val context = linkedMapOf <String, String>(
                "schema" to "http://schema.org/",
                "name" to "schema:name",
                "homepage" to "schema:url",
                "image" to "schema:image"
                )

        val claim = linkedMapOf <String, Any>(
                "@context" to context,
                "name" to "smart-b",
                "homepage" to "https://smart-b.city",
                "image" to "https://smart-b.city/wp-content/uploads/2019/05/LOGO-SMART-B-BLACK-WEB.png"
        )

        val creator = URI.create("https://smart-b.city/keys/${signerAdmin.name}")
        val created = "2017-10-24T05:33:31Z"
        val domain = "smart-b.city"
        val nonce: String? = UUID.randomUUID().toString()

        val signer = RsaSignature2017LdSigner(creator, created, domain, nonce, signerAdmin.pair.private as RSAPrivateKey)
        signer.sign(claim)
        return claim;
    }

}

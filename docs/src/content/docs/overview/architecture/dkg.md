---
title: DKG
description: A short overview of the Decentralized Knowledge Graph.
---

OriginTrail's Decentralized Knowledge Graph (DKG) is a decentralized graph database that stores verified data on the blockchain. It's used by Truthchain to store verified data.

Data that is stored to DKG

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `@context` | `string` | The context of the Snippet. |
| `@id` | `string` | The Truthchain Snippet URL containing UUID |
| `@type` | `string` | "TruthchainSnippet" is used by default |
| `title` | `string` | The title of the Snippet. |
| `content` | `string` | The content of the Snippet. |
| `source` | `string` | The source of the Snippet. |
| `verified` | `boolean` | Whether the Snippet is verified. |
| `createdBy` | `object` | The user that created the Snippet. |
| `createdBy.publicAddress` | `string` | The public address of the user that created the Snippet. |
| `verifiedBy` | `array` | The verifier that verified the Snippet. |
| `verifiedBy.@type` | `string` | "TruthchainVerifier" is used by default |
| `verifiedBy.name` | `string` | The name of the verifier. |
| `verifiedBy.verified` | `boolean` | Whether the verifier verified the Snippet. |


**Example JSON**
```json
{
    '@context': 'https://schema.org',
    '@id': 'https://truthchain.dev/snippets/ac3edf4e-0b0a-4b0e-8b0a-4b0e8b0a4b0e',
    '@type': 'TruthchainSnippet',
    'title': 'Fund your v6 testnet node',
    'content': 'OriginTrail v6 testnet nodes operate on the OriginTrail Parachain testnet, and therefore operate with test tokens. For a node to be operational, it requires OTP and TRAC test tokens for OTP testnet',
    'source': 'https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node',
    'verified': true,
    'createdBy': {
        '@type': 'User',
        'publicAddress': '0x1234567890',
    },
    'verifiedBy': [
        {
            '@type': 'TruthchainVerifier',
            'name': 'web-scraper',
            'verified': true
        },
        {
            '@type': 'TruthchainVerifier',
            'name': 'social-media-verifier',
            'verified': false
        },
        {
            '@type': 'TruthchainVerifier',
            'name': 'youtube-verifier',
            'verified': true
        }
    ]

}
```

Learn more about DKG [here](https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/dkg-basic-concepts).
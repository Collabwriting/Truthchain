---
title: DKG
description: A short overview of the Decentralized Knowledge Graph.
---

OriginTrail's Decentralized Knowledge Graph (DKG) is a decentralized graph database that stores verified data on the blockchain. It's used by Truthchain to store verified data.

Data that is stored to DKG

```json
{
    '@context': 'https://schema.org',
    '@id': 'https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node#:sid:=b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b&:tid:=0956eb9e-e998-45f9-90f0-086f823a3ea8#:~:text=v6%20testnet%20node-,origintrail%20v6%20testnet%20nodes%20operate%20on%20the%20origintrail%20parachain%20testnet%2C%20and%20therefore%20operate%20with%20test%20tokens.%20for%20a%20node%20to%20be%20operational%2C%20it%20requires%20otp%20and%20trac%20test%20tokens%20for%20otp%20testnet',
    '@type': 'Snippet',
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
            '@type': 'Validator',
            'name': 'web-scraper',
            'verified': true
        },
        {
            '@type': 'Validator',
            'name': 'social-media-validator',
            'verified': false
        },
        {
            '@type': 'Validator',
            'name': 'youtube-validator',
            'verified': true
        }
    ]

}
```

Learn more about DKG [here](https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/dkg-basic-concepts).
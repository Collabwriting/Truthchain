---
title: Truthchain API
description: A short overview Truthchain's API
---

Truthchain is the main component of the Truthchain System. It is a backend service with open APIs that allows users to collect data from various online sources and submit it to Truthchain for verification.

## Snippet API ```/snippets```
The Snippet API allows users to submit Snippets to Truthchain for verification. Snippets are sent to Data Verifiers for verification and then stored on the blockchain using OriginTrail's Decentralized Knowledge Graph.

### Submit Snippet ```POST /snippets```
The Submit Snippet endpoint allows users to submit Snippets to Truthchain for verification. Snippets are sent to Data Verifiers for verification and then stored on the blockchain using OriginTrail's Decentralized Knowledge Graph.

```http
POST /snippet
```

#### Request body
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `title` | `string` | **Required**. The title of the Snippet. |
| `content` | `string` | **Required**. The content of the Snippet. |
| `type` | `string` | **Required**. The type of the Snippet. |
| `source` | `string` | **Required**. The source of the Snippet. |
| `url` | `string` | **Required**. The URL of the Snippet. |
| `submittedBy` | `object` | **Required**. The user that submitted the Snippet. |
| `submittedBy.publicAddress` | `string` | **Required**. The public address of the user that submitted the Snippet. |
| `submittedBy.signature` | `string` | **Required**. The signature of the user that submitted the Snippet. |

**Request body example**
```json
{
    title: "Fund your v6 testnet node",
    content: "OriginTrail v6 testnet nodes operate on the OriginTrail Parachain testnet, and therefore operate with test tokens. For a node to be operational, it requires OTP and TRAC test tokens for OTP testnet",
    type: "article",
    source: "https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node",
    url: "https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node#:sid:=b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b&:tid:=0956eb9e-e998-45f9-90f0-086f823a3ea8#:~:text=v6%20testnet%20node-,origintrail%20v6%20testnet%20nodes%20operate%20on%20the%20origintrail%20parachain%20testnet%2C%20and%20therefore%20operate%20with%20test%20tokens.%20for%20a%20node%20to%20be%20operational%2C%20it%20requires%20otp%20and%20trac%20test%20tokens%20for%20otp%20testnet",
    submittedBy: {
        publicAddress: "0x1234567890",
        signature: "0x1234567890"
    }
}
```

#### Response body
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `uuid` | `string` | The UUID of the Snippet. |
| `ual` | `string` | The UAL of the Snippet. |
| `verified` | `boolean` | Whether the Snippet is verified. |
| `type` | `string` | The type of the Snippet. |
| `title` | `string` | The title of the Snippet. |
| `content` | `string` | The content of the Snippet. |
| `source` | `string` | The source of the Snippet. |
| `url` | `string` | The URL of the Snippet. |
| `submittedBy` | `object` | The user that submitted the Snippet. |
| `submittedBy.publicAddress` | `string` | The public address of the user that submitted the Snippet. |
| `verifiedBy` | `array` | The verifiers that verified the Snippet. |
| `verifiedBy.name` | `string` | The name of the verifier. |
| `verifiedBy.verified` | `boolean` | Whether the verifier verified the Snippet. |

**Response body example**
```json
{
    ...snippet,

    uuid: "b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b",
    ual: "0956eb9e-e998-45f9-90f0-086f823a3ea8"
    verified: true,

    verifiedBy: [
        {
            name: "web-scraper",
            verified: true
        },
        {
            name: "social-media-verifier",
            verified: false
        },
        {
            name: "youtube-verifier",
            verified: true
        }
    ]

}
```

### Get Snippet ```GET /snippets/:uuid```
The Get Snippet endpoint allows users to get a Snippet by its UUID.

```http
GET /snippet/:uuid
```

#### Request parameters
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `uuid` | `string` | **Required**. The UUID of the Snippet to get. |

#### Response body
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `uuid` | `string` | The UUID of the Snippet. |
| `ual` | `string` | The UAL of the Snippet. |
| `verified` | `boolean` | Whether the Snippet is verified. |
| `type` | `string` | The type of the Snippet. |
| `title` | `string` | The title of the Snippet. |
| `content` | `string` | The content of the Snippet. |
| `source` | `string` | The source of the Snippet. |
| `url` | `string` | The URL of the Snippet. |
| `submittedBy` | `object` | The user that submitted the Snippet. |
| `submittedBy.publicAddress` | `string` | The public address of the user that submitted the Snippet. |
| `verifiedBy` | `array` | The verifiers that verified the Snippet. |
| `verifiedBy.name` | `string` | The name of the verifier. |
| `verifiedBy.verified` | `boolean` | Whether the verifier verified the Snippet. |

**Example**
```json
{
    uuid: "b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b",
    ual: "0956eb9e-e998-45f9-90f0-086f823a3ea8"
    verified: true,

    type: "article",
    title: "Fund your v6 testnet node",
    content: "OriginTrail v6 testnet nodes operate on the OriginTrail Parachain testnet, and therefore operate with test tokens. For a node to be operational, it requires OTP and TRAC test tokens for OTP testnet",
    source: "https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node",
    url: "https://docs.origintrail.io/decentralized-knowledge-graph-layer-2/node-setup-instructions/fund-your-v6-testnet-node#:sid:=b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b&:tid:=0956eb9e-e998-45f9-90f0-086f823a3ea8#:~:text=v6%20testnet%20node-,origintrail%20v6%20testnet%20nodes%20operate%20on%20the%20origintrail%20parachain%20testnet%2C%20and%20therefore%20operate%20with%20test%20tokens.%20for%20a%20node%20to%20be%20operational%2C%20it%20requires%20otp%20and%20trac%20test%20tokens%20for%20otp%20testnet",

    submittedBy: {
        publicAddress: "0x1234567890",
    },

    verifiedBy: [
        {
            name: "web-scraper",
            verified: true
        },
        {
            name: "social-media-verifier",
            verified: false
        },
        {
            name: "youtube-verifier",
            verified: true
        }
    ]

}
```

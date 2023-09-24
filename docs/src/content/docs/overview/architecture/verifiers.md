---
title: Data Verifiers
description: A short overview of Data Verifiers.
---

Data Verifiers are services that verify the accuracy and credibility of data. Truthchain implements data verification by creating interfaces to other services, known as Data Verifiers, that can verify the submitted data. These Data Verifiers employ various techniques to assess the accuracy and credibility of the information.

Data Verifiers are defined in the `data-verifiers.json` file. This file contains a list of Data Verifiers. Truthchain uses this file to determine which Data Verifier to send a Snippet to for verification.

```json
{
  "dataVerifiers": [
    {
      "name": "web-scraper",
      "url": "http://localhost:3001/verify"
    },
    {
      "name": "social-media-verifier",
      "url": "http://localhost:3002/verify"
    },
    {
      "name": "youtube-verifier",
      "url": "http://localhost:3003/verify"
    }
  ]
}
```
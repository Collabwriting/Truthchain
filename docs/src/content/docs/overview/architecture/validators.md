---
title: Data Validators
description: A short overview of Data Validators.
---

Data Validators are services that verify the accuracy and credibility of data. Truthchain implements data verification by creating interfaces to other services, known as Data Validators, that can verify the submitted data. These Data Validators employ various techniques to assess the accuracy and credibility of the information.

Data Validators are defined in the `data-validators.json` file. This file contains a list of Data Validators. Truthchain uses this file to determine which Data Validator to send a Snippet to for verification.

```json
{
  "dataValidators": [
    {
      "name": "web-scraper",
      "url": "http://localhost:3001/verify"
    },
    {
      "name": "social-media-validator",
      "url": "http://localhost:3002/verify"
    },
    {
      "name": "youtube-validator",
      "url": "http://localhost:3003/verify"
    }
  ]
}
```
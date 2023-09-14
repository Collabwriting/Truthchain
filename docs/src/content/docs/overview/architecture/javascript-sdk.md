---
title: JavaScript SDK
description: A short overview of the JavaScript SDK.
---

The JavaScript SDK is a JavaScript library that allows users to collect data from various online sources and submit it to Truthchain for verification.

### Installation
Install the JavaScript SDK using npm:
```bash
npm install @truthchain/sdk
```

### Usage
Import the JavaScript SDK into your project:
```javascript
import Truthchain from '@truthchain/sdk';
```

Create a new instance of the JavaScript SDK:
```javascript
const truthchain = new Truthchain();
```

Submit a Snippet to Truthchain for verification:
```javascript
let snippet = await truthchain.verify({
    content: 'Hello World!',
    source: 'https://example.com',
    signature: '0x1234567890',
    publicKey: '0x1234567890'
});
```

Retrieve a Snippet from Truthchain:
```javascript
let snippet = await truthchain.get('b7fa9c63-44f3-4cb1-9ae7-cd24be4fe90b');
```
---
title: Architecture
description: A short overview of the architecture of the Truthchain System.
---

Understanding [concepts](/overview/concepts) is important, but understanding how they fit together is even more important. This section will give you a brief overview of the architecture of the Truthchain System.

## Component Diagram
Here's a simple component diagram that shows the key components of the Truthchain System.

<img height="350px" src="https://github.com/Collabwriting/Truthchain/assets/9627557/e07a50e8-cd50-43bb-ba4c-1ef9fec0300d"/>

Main components of the Truthchain System include:
- **Truthchain**: Backend service that collects data from users and sends it to Data Verifiers for verification.
- **JavaSript SDK**: JavaScript library that allows users to collect data from various online sources and submit it to Truthchain for verification.
- **DKG**: OriginTrail's Decentralized Knowledge Graph that stores verified data on the blockchain.
- **Database**: Database that stores information about users and their Snippets.
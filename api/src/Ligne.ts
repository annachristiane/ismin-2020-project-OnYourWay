export interface hits {
  nhits: bigint;
  records: Array<record>;
}

export function getRecords(hits: hits): record[]{
  return hits.records;
}

export function getLignes(records: record[]): Ligne[]{
  const array: Ligne[] = [];
  for (let _i = 0; _i < records.length; _i++) {
    array.push({"status":records[_i].fields.status,
      "id_line":records[_i].fields.id_line,
      "transportsubmode": records[_i].fields.transportsubmode,
      "transportmode": records[_i].fields.transportmode,
      "shortname_line":records[_i].fields.shortname_line,
      "name_line":records[_i].fields.name_line,
      "shortname_groupoflines": records[_i].fields.shortname_groupoflines,
      "networkname":records[_i].fields.networkname,
      "operatorname":records[_i].fields.operatorname,
      "accessibility":records[_i].fields.accessibility});
  }
  return array;
}

export interface record {
  recordid: string;
  fields: Ligne;
}

export interface Ligne{
  status: string;
  id_line: string;
  transportsubmode: string;
  transportmode: string;
  shortname_line: string;
  name_line: string;
  shortname_groupoflines: string;
  networkname: string;
  operatorname: string;
  accessibility: string;
}


